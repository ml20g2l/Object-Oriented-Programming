public class AlarmClock extends Clock {

    private int alarmHours;
    private int alarmMinutes;

    public AlarmClock() {
        super();
    }

    public AlarmClock(int h, int m, int s) {
        super(h, m, s);
    }

    public AlarmClock(int h, int m) {
        super(h, m);
    }

    public int getAlarmHours() {
        return alarmHours;
    }

    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    public void setAlarm(int h, int m) {
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("Invalid alarm hours.");
        }
        if (m < 1 || m > 59) {
            throw new IllegalArgumentException("Invalid alarm minutes.");
        }
        this.alarmHours = h;
        this.alarmMinutes = m;
    }

    public boolean isRinging(){
        return getHours() == getAlarmHours() && getMinutes() == getAlarmMinutes() && getSeconds() <= 15;
    }

    @Override
    public void display(){
        if (isRinging()){
            System.out.println(super.toString() + " - WAKE UP!");
        }else{
            super.display();
        }

    }


}
