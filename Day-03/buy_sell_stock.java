public class buy_sell_stock {
    public static int buy_sell_stock(int[] arr){
        int buy_price=arr[0];
        int profit=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]<buy_price){
                buy_price=arr[i];
            }
            else{
                int current_profit=arr[i]-buy_price;
                profit=Math.max(profit,current_profit);
            }
        }
        return (int) profit;
    }
    public static void main(String[] args) {
        int[] arr = {11,5,9,3,5,12,6};
        int res=buy_sell_stock(arr);
        System.out.println(res);

    }
}
