public class CardioSession extends Session {
    private User user;
    private Workout workout;
    private int duration;
    private String type;

    public CardioSession(User user, Workout workout, int duration, String type) {
        super(user, workout, duration, type);
        this.user = user;
        this.workout = workout;
        this.duration = duration;
        this.type = "Cardio";
    }
    public void TestPrint() {
        System.out.println(user + " is doing " + type);
    }
}   
