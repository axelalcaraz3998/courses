public class Main {

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    boolean isAlien = false;
    if (!isAlien) {
      System.out.println("It's not an alien.");
    } else {
      System.out.println("It's an alien!");
    }

    int topScore = 80;
    if (topScore < 100) {
      System.out.println("You didn't get the high score.");
    }

    int secondTopScore = 60;
    if ((topScore > secondTopScore) && (topScore < 100)) {
      System.out.println("Greater than second top score and less than 100.");
    }

    if ((topScore > 90) || (secondTopScore <= 90)) {
      System.out.println("Either or both conditions are true.");
    }

    String makeOfCar = "Volkswagen";
    boolean isDomestic = makeOfCar.equals("Volkswagen") ? false : true;
    if (isDomestic) {
      System.out.println("This car is domestic to our country.");
    }
  }

}