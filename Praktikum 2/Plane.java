import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane extends Actor
{
    /**
     * Act - do whatever the Plane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
public Plane() {
        GreenfootImage img = this.getImage();
        img.scale(140, 100);
        this.setImage(img);
    }
    private int speed = 6;
    private Random random = new Random();
    
    public void act() {
        if(random.nextInt(100) < 1) {
            // Secara acak pilih untuk mengubah arah setiao beberapa langkah
            randomTurn();
        }
        move(speed);
        
        // cek apakah pesawat berada dekat dengan tepi latar belakang
        if (isCloseToEdge()) {
            avoidWall(); // panggil metode untuk menghindari dinding
        }
    }
    
    private boolean isCloseToEdge() {
        int edgeDistance = 20; 
        int x = getX();
        int y = getY();
        int width = getWorld().getWidth();
        int height = getWorld().getHeight();
        
        return x <= edgeDistance || x >= width - edgeDistance || y <= edgeDistance || y >= height - edgeDistance;
    }
    private void avoidWall() {
        // menggunakan logika untuk menghindari dinding
        // Misalnya, putar pesawat sekitar 90 derajat kekiri
        turn(-90);
        move(speed);
    }
    private void randomTurn() {
        // Memutar pesawat secara acak antara -45 hingga 45 derajat
        int angle = random.nextInt(45) - 45;
        turn(angle);
    }
}
