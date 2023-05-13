public class Session {
    private User user;
    private Workout workout;
    
    public Session(User user, Workout workout) {
        this.user = user;
        this.workout = workout;
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
}
