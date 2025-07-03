public class trapping_rain_water {
    public static int trappingRainWater(int[] nums){
        int ans=0, l=0, r=nums.length-1, lmax=0, rmax=0;

        while (l<r){
            lmax=Math.max(lmax,nums[l]);
            rmax=Math.max(rmax,nums[r]);

            if(lmax<rmax){
                ans+= (lmax-nums[l]);
                l++;
            }else {
                ans += (rmax-nums[r]);
                r++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] map={4,2,0,3,2,5};
        System.out.println(trappingRainWater(map));
    }
}
