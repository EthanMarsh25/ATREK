import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Basket {
    
    private int pepperoniTotal;
    private int hawaiianTotal;
    private int margheritaTotal;
    private int chickenTotal;
    private int garlicTotal;
    private int saleTotal;
    JTextArea viewBasket = new JTextArea();

    private String customerForename;
    private String customerSurname;
    int[] customerBasket = new int[5];

    public Basket(int pepperoniTotal, int hawaiianTotal, int margheritaTotal, int chickenTotal, int garlicTotal) {
        this.pepperoniTotal = pepperoniTotal;
        this.hawaiianTotal = hawaiianTotal;
        this.margheritaTotal = margheritaTotal;
        this.chickenTotal = chickenTotal;
        this.garlicTotal = garlicTotal;

    }

    public int getPepperoni() {
        return pepperoniTotal;
    }

    public void addPepperoni() {

        if (pepperoniTotal < 10) {
            pepperoniTotal++;
            JOptionPane.showMessageDialog(null, "Pepperoni Pizza added to your basket");
        } else if (pepperoniTotal == 10) {
            JOptionPane.showMessageDialog(null, "Unable to add more of this pizza, you have already reached its limit");
            return;
        }
    }

    public void setPepperoni() {
        customerBasket[0] = pepperoniTotal;
    }

    //hawaiian

    public void addHawaiian() {
        if (hawaiianTotal < 10) {
            hawaiianTotal++;
            JOptionPane.showMessageDialog(null, "Hawaiian Pizza added to your basket");
        } else if (hawaiianTotal == 10) {
            JOptionPane.showMessageDialog(null, "Unable to add more of this pizza, you have already reached its limit");
            return;
        }
    }

    public void setHawaiian() {
        customerBasket[1] = hawaiianTotal;
    }

    //margherita

    public void addMargherita() {
        if (margheritaTotal < 10) {
            margheritaTotal++;
            JOptionPane.showMessageDialog(null, "Margherita Pizza added to your basket");
        } else if (margheritaTotal == 10) {
            JOptionPane.showMessageDialog(null, "Unable to add more of this pizza, you have already reached its limit");
            return;
        }
    }

    public void setMargherita() {
        customerBasket[2] = margheritaTotal;
    }

    //chicken

    public void addChicken() {
        if (chickenTotal < 10) {
            chickenTotal++;
            JOptionPane.showMessageDialog(null, "Chicken Pizza added to your basket");
        } else if (chickenTotal == 10) {
            JOptionPane.showMessageDialog(null, "Unable to add more of this pizza, you have already reached its limit");
            return;
        }
    }

    public void setChicken() {
        customerBasket[3] = chickenTotal;
    }

    //garlic

    public void addGarlic() {
        if (garlicTotal < 10) {
            garlicTotal++;
            JOptionPane.showMessageDialog(null, "Garlic Pizza added to your basket");
        } else if (garlicTotal == 10) {
            JOptionPane.showMessageDialog(null, "Unable to add more of this pizza, you have already reached its limit");
            return;
        }
    }

    public void setGarlic() {
        customerBasket[4] = garlicTotal;
    }

    public int getHawaiian() {
        return hawaiianTotal;
    }

    public int getMargherita() {
        return margheritaTotal;
    }

    public int getChicken() {
        return chickenTotal;
    }

    public int getGarlic() {
        return garlicTotal;
    }

    public void setName(String forename, String surname) {
        if(!forename.isEmpty() && !surname.isEmpty()){
            customerForename=forename;
            customerSurname=surname;
        }
    }

    public String getName(){
        return (customerForename  + " " + customerSurname);
    }

    public int getSaleTotal(){
        return saleTotal;
    }

    public void clearName(){
        customerForename="";
        customerSurname="";
    }

    public void clearBasket() {
        pepperoniTotal = 0;
        hawaiianTotal = 0;
        margheritaTotal = 0;
        chickenTotal = 0;
        garlicTotal = 0;
        viewBasket.setText("");
    }

    public void clearSale(){
        saleTotal=0;
    }
    
    

    public void addToBasket(){
        viewBasket.setText("");
        if (customerBasket[0] != 0) {
            String temp = Integer.toString(customerBasket[0]);
            viewBasket.append("Pepperoni Pizza x" +temp+ "  Cost: £" +customerBasket[0]*10 +  "\n");
            
        }
        
        if (customerBasket[1] != 0) {
            String temp = Integer.toString(customerBasket[1]);
            viewBasket.append("Hawaiian Pizza x" + temp + "  Cost: £" +customerBasket[1]*10 + "\n");
        }
        
        if (customerBasket[2] != 0) {
            String temp = Integer.toString(customerBasket[2]);
            viewBasket.append("Margherita Pizza x" + temp + "  Cost £"+customerBasket[2]*10 +  "\n");
        }
        
        if (customerBasket[3] != 0) {
            String temp = Integer.toString(customerBasket[3]);
            viewBasket.append("Chicken Pizza x" + temp +  "  Cost: £" +(customerBasket[3]*10) + "\n");
        }
        
        if (customerBasket[4] != 0) {
            String temp = Integer.toString(customerBasket[4]);
            viewBasket.append("Garlic Pizza x" + temp + " Cost: £" +customerBasket[4]*10 + "\n");
        }
    
        if (customerBasket[0] == 0 && customerBasket[1] == 0 && customerBasket[2] == 0 && customerBasket[3] == 0 && customerBasket[4] == 0){
            viewBasket.append("Basket Empty\n");
        }
        else{

            saleTotal=customerBasket[0]*10 + customerBasket[1]*10 + customerBasket[2]*10 + customerBasket[3]*10 + customerBasket[4]*10;
            viewBasket.append("Sale Amount: £" + saleTotal);
        }     
    }
    
    public boolean isBasketEmpty() {
        return chickenTotal == 0 &&
               margheritaTotal == 0 &&
               pepperoniTotal == 0 &&
               garlicTotal == 0 &&
               hawaiianTotal == 0;
    }
}
