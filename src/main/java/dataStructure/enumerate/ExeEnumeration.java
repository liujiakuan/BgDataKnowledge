package dataStructure.enumerate;

public class ExeEnumeration {
    public static void main(String[]  ljk){
        System.out.println(Enum.BLUE.getCode());
        System.out.println(Enum.BLUE.getColor());
        System.out.println(Enum.GREEN.getColor());
        System.out.println(Enum.GREEN.getColor());
        System.out.println(Enum.RED.getColor());
        System.out.println(Enum.RED.getColor());

         Enum[] enums = Enum.values();
         enums[0].setCode(100);
         enums[0].setColor("Tomato");

         for(Enum enumsArry:enums){
             System.out.println(enumsArry);
         }
    }
}
