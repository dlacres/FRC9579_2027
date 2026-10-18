package frc.robot;

public class Path {
    private final int SEGMENT1 = 0;
    private final int SEGMENT2 = 1 ;

    int state = 0;
    Path(){

    }
    boolean Forward(double distance){
        return(false);
    }
    boolean Turn(double distance){
        return(false);
    }

    int numTurns=0;
    
    void driveSquare(){

        switch(state){
            case SEGMENT1:
                break;
            case SEGMENT2:
                break;
            default:
        }        
    }
}
