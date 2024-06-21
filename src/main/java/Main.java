public class Main {
    public static void main(String[] args) {
        String[] cities = {"Лубни", "Миргород", "Полтава", "Місто"};
        String[] streets = {"Першотравнева", "Вербова", "Історична", "Вулиця"};
        for(int i = 0; i < cities.length; i++) {
            System.out.println("Щоб отримати графік відключень електроенергії по Полтавській області\nВведіть назву населеного пункту: " + cities[i]);
            System.out.println("Введіть назву вулиці: " + streets[i]);
            Address address = new Address(streets[i], cities[i]);
            ScheduleScraper scraper = new ScheduleScraper();
            Schedule schedule = scraper.getSchedule(address);
            System.out.println("\n" + schedule.getGroup() + "\nГрафік відключень на сьогодні\n" + schedule.getScheduleString() + "\n\n");
        }
    }
}
