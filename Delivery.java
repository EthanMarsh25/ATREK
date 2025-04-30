import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Delivery{
    
    private int [] deliveryTotals = new int[10];
    private int flourTotal;
    private int oliveTotal;
    private int sausageTotal;
    private int pineappleTotal;
    private int basilTotal;
    private int chickenBreastTotal;
    private int tomatoesTotal;
    private int mozzarellaTotal;
    private int hamTotal;
    private int garlicStockTotal;
    private int deliveryCost;

    JTextArea viewOrder = new JTextArea();

    




    public Delivery(int flourTotal, int oliveTotal, int sausageTotal, int basilTotal, int tomatoesTotal, int garlicStockTotal, int pineappeTotal, int hamTotal, int chickenBreastTotal, int mozzarellaTotal) {
        deliveryTotals[0] = flourTotal;
        deliveryTotals[1] = oliveTotal;
        deliveryTotals[2] = sausageTotal;
        deliveryTotals[3] = basilTotal;
        deliveryTotals[4] = tomatoesTotal;
        deliveryTotals[5] = garlicStockTotal;
        deliveryTotals[6] = pineappeTotal;
        deliveryTotals[7] = hamTotal;
        deliveryTotals[8] = chickenBreastTotal;
        deliveryTotals[9] = mozzarellaTotal;
    }
    public int getDeliveryCost(){
        return deliveryCost;
    }
    public void setDeliveryCost(int num){
        deliveryCost=num;
    }

    public void initiateStock() {
        //used at the start of program execution
        ///reads through stockquantities file and assigns each stock value to its respective ingredient
        try (BufferedReader br = new BufferedReader(new FileReader("stockQuantities.txt"))) {
            
            String line = br.readLine();
            int lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[0]= lineText;
            

            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[1]= lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[2] = lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[3] = lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[4] = lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[5]= lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[6] = lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[7]= lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[8] = lineText;
            
            line = br.readLine();
            lineText = Integer.parseInt(line);
            System.out.println("lineText =" + lineText);
            deliveryTotals[9] = lineText;
    
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(null, "Failed to read file");
        }
    }

    public int getFlour(){
        return deliveryTotals[0];
    
    }
    
    public void addFlour(){
        flourTotal++;
        }
    

    public int getOlive(){
        return deliveryTotals[1];
    }
    public void addOlive(){
        oliveTotal++;
        
    }

    public int getSausage(){
        return deliveryTotals[2];
    }
    public void addSausage(){
        sausageTotal++;
    }
    
    public int getBasil(){
        return deliveryTotals[3];
    }
    public void addBasil(){
        basilTotal++;
    }

    public int getTomatoes(){
        return deliveryTotals[4];
    }
    public void addTomatoes(){
        tomatoesTotal++;
    }

    public int getGarlicStock(){
        return deliveryTotals[5];
    }
    public void addGarlic(){
        garlicStockTotal++;
    }
    
    ///
    public int getHam(){
        return deliveryTotals[6];
    }
    public void addHam(){
        hamTotal++;
    }

    
    public int getChickenBreast(){
        return deliveryTotals[7];
    }
    public void addChickenBreast(){
        chickenBreastTotal++;
    }

    
    public int getMozzarella(){
        return deliveryTotals[8];
    }
    public void addMozzarella(){
        mozzarellaTotal++;
    }

    public int getPineappleTotal(){
        return deliveryTotals[9];
    }
    public void addPineapple(){
        pineappleTotal++;
    }

    public void clearDelivery() {
        flourTotal=0;
        oliveTotal=0;
        sausageTotal=0;
        pineappleTotal=0;
        basilTotal=0;
        chickenBreastTotal=0;
        tomatoesTotal=0;
        mozzarellaTotal=0;
        hamTotal=0;
        garlicStockTotal=0;
    }

    public void clearDeliveryTotal(){
        deliveryCost=0;
    }

    public void setFlourTotal() {
        deliveryTotals[0] = deliveryTotals[0] + flourTotal;
    }
    
    public void setOliveTotal() {
        deliveryTotals[1] = deliveryTotals[1] + oliveTotal;
    }
    
    public void setSausageTotal() {
        deliveryTotals[2] = deliveryTotals[2] +sausageTotal;
    }
    
    public void setBasilTotal() {
        deliveryTotals[3] = deliveryTotals[3] + basilTotal;
    }
    
    public void setTomatoesTotal() {
        deliveryTotals[4] =  deliveryTotals[4] + tomatoesTotal;
    }
    
    public void setGarlicStockTotal() {
        deliveryTotals[5] = deliveryTotals[5] +  garlicStockTotal;
    }
    
    public void setPineappleTotal() {
        deliveryTotals[6] = deliveryTotals[6] +  pineappleTotal;
    }
    
    public void setHamTotal() {
        deliveryTotals[7] = deliveryTotals[7]+ hamTotal;
    }
    
    public void setChickenBreastTotal() {
        deliveryTotals[8] = deliveryTotals[8]+chickenBreastTotal;
    }

    
    public void setMozzarellaTotal() {
        deliveryTotals[9] = deliveryTotals[9]+ mozzarellaTotal;
    }

    public void addToDelivery() { //adds all of the users ordered items to the vieworder text area 
        viewOrder.setText("");

        //variables for storing the total amount spent on each item in the current delivery
        int flourCost=0;
        int oliveCost=0;
        int sausageCost=0;
        int basilCost=0;
        int tomatoesCost=0;
        int garlicCost=0;
        int pineappleCost=0;
        int hamCost=0;
        int chickenBreastCost=0;
        int mozzarellaCost=0;

        if (flourTotal!= 0) {
            flourCost=flourTotal*5;
            String temp = Integer.toString(flourTotal);
            viewOrder.append("Flour x" + temp + "  Cost: £" +flourCost + "\n");
        }
    
        if (oliveTotal!= 0) {
            oliveCost=oliveTotal*4;
            String temp = Integer.toString(oliveTotal);
            viewOrder.append("Olive oil x" + temp +  "  Cost: £"  + oliveCost + "\n");
        }
    
        if (sausageTotal != 0) {
            sausageCost=sausageTotal*3;
            String temp = Integer.toString(sausageTotal);
            viewOrder.append("Sausage x" + temp + "  Cost: £" +sausageCost + "\n");
        }
    
        if (basilTotal != 0) { 
            basilCost=basilTotal*3;
            String temp = Integer.toString(basilTotal);
            viewOrder.append("Basil x" + temp + "  Cost: £" + basilCost + "\n");
        }
    
        if (tomatoesTotal!= 0) {
            tomatoesCost=tomatoesTotal*3;
            String temp = Integer.toString(tomatoesTotal);
            viewOrder.append("Tomatoes x" + temp + "  Cost: £" + tomatoesCost + "\n");
        }
    
        if (garlicStockTotal!= 0) {
            garlicCost=garlicStockTotal*3;
            String temp = Integer.toString(garlicStockTotal);
            viewOrder.append("Garlic Stock x" + temp + "  Cost: £" +garlicCost +"\n");
        }
    
        if (pineappleTotal!=0) {
            pineappleCost=pineappleTotal*3;
            String temp = Integer.toString(pineappleTotal);
            viewOrder.append("Pineapple x" + temp + "  Cost: £" +pineappleCost + "\n");
        }
    
        if (hamTotal!=0) {
            hamCost=hamTotal*4;
            String temp = Integer.toString(hamTotal);
            viewOrder.append("Ham x" + temp +"  Cost: £" +hamCost + "\n");
        }
    
        if (chickenBreastTotal!=0) {
            chickenBreastCost=chickenBreastTotal*5;
            String temp = Integer.toString(chickenBreastTotal);
            viewOrder.append("Chicken Breast x" + temp + "  Cost: £" +chickenBreastCost + "\n");
        }
    
        if (mozzarellaTotal != 0) {

            mozzarellaCost=mozzarellaTotal*4;
            String temp = Integer.toString(mozzarellaTotal);
            viewOrder.append("Mozzarella x" + temp +"  Cost: £" +mozzarellaCost + "\n");
        }
        deliveryCost=(flourCost+oliveCost+sausageCost+basilCost+pineappleCost+hamCost+garlicCost+mozzarellaCost+chickenBreastCost+tomatoesCost);
        //String deliveryCostText=Integer.toString(deliveryCost);
        if (flourTotal== 0 && oliveTotal == 0 && sausageTotal == 0 && hamTotal == 0 &&  basilTotal == 0 && pineappleTotal == 0 && mozzarellaTotal== 0 && chickenBreastTotal == 0 && garlicStockTotal == 0 && tomatoesTotal == 0){
            return;
        }
        viewOrder.append("Total Cost: £" +deliveryCost +"\n");
    }
    
        
}