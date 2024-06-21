import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleScraper {
    public Schedule getSchedule(Address address) {
        List<String> schedule = new ArrayList<>();
        String group = "";
        String url = "https://energy-ua.info/grafik/" + address.getCity() + "/" + address.getStreet().replaceAll(" ", "+");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    Document doc = Jsoup.parse(result);
                    Elements periods = doc.select(".grafik_string_list_item span");
                    for (Element period : periods) {
                        schedule.add(period.text());
                    }
                    group = doc.select(".channel_notice").text();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Schedule(group, schedule);
    }
}
