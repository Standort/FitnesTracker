public class WeightLiftingSession extends Session {
    private User user;
    private Workout workout;
    private int duration;
    private String type;

    public WeightLiftingSession(User user, Workout workout, int duration, String type) {
        super(user, workout, duration, type);
        this.user = user;
        this.workout = workout;
        this.duration = duration;
        this.type = "WeightLifting";
        //TODO Auto-generated constructor stub
    }
    public void TestPrint() {
        System.out.println(user + " is doing " + type);
    }
}   
