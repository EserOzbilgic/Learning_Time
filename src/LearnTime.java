import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LearnTime extends JFrame {
    public static void main(String[] args) {
        LearnTime pannel = new LearnTime();
      pannel.setVisible(true);
    }


    private static final String[] CITIES = new String[]{"New York", "London", "Paris", "Tokyo", "Johannesburg", "Istanbul", "Baku", "Dubai", "Berlin", "Auckland","Roma","Mexico_City","Seoul"};
    private static final TimeZone[] TIME_ZONES = new TimeZone[]{TimeZone.getTimeZone("America/New_York"), TimeZone.getTimeZone("Europe/London"), TimeZone.getTimeZone("Europe/Paris"), TimeZone.getTimeZone("Asia/Tokyo"), TimeZone.getTimeZone("Africa/Johannesburg"), TimeZone.getTimeZone("Europe/Istanbul"), TimeZone.getTimeZone("Asia/Baku"), TimeZone.getTimeZone("Asia/Dubai"), TimeZone.getTimeZone("Europe/Berlin"), TimeZone.getTimeZone("Pacific/Auckland"),TimeZone.getTimeZone("America/Mexico_City"),TimeZone.getTimeZone("Asia/Seoul"),TimeZone.getTimeZone("Europe/Roma")};
    private final JLabel timeLabel = new JLabel("", 0);

    public LearnTime() {
        this.setDefaultCloseOperation(3);
        this.setTitle("Live Time Zones");
        this.setSize(600, 400);
        JComboBox<String> cityComboBox = new JComboBox(CITIES);
        cityComboBox.addActionListener((e) -> {
            this.updateTime();
        });
        this.add(this.timeLabel, "Center");
        this.add(cityComboBox, "South");
        this.updateTime();
    }

    private void updateTime() {
        int cityIndex = ((JComboBox)this.getContentPane().getComponent(1)).getSelectedIndex();
        Calendar calendar = Calendar.getInstance(TIME_ZONES[cityIndex]);
        int hour = calendar.get(11);
        int minute = calendar.get(12);
        int second = calendar.get(13);
        this.timeLabel.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }


}

