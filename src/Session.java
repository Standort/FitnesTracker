import java.time.LocalDateTime;

public class Session {
    private User user;
    private Workout workout;
    private LocalDateTime dateOfCreation;
    private int duration;//seconds
    
    public Session(User user, Workout workout, int duration) {
        this.user = user;
        this.workout = workout;
        this.dateOfCreation = LocalDateTime.now();
        this.duration = duration;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Workout getWorkout() {
        return workout;
    }
    
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    
    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }
    
    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public float getCaloriesBurned(){
        float cb = workout.getCaloriesPerMinute() * this.duration;
        return cb;

    }
}
