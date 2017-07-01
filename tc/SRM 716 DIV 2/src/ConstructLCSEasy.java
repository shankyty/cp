

public class ConstructLCSEasy {

    public String construct(int ab, int bc, int ca) {
        String A = new String();
        String B = new String();
        String C = new String();
        for(int i = 0;i<Math.max(ab,ca);i++)
            A = A+ "1";
        for(int j = 0;j<Math.min(ab,bc);j++)
            B = B+ "1";
        for(int i=0;i<Math.max(bc,ca);i++)
            C = C + "1";
        for(int i=0;i<Math.min(bc,ca)-Math.min(ab,bc);i++)
        {
            C = C+"0";
            B = B+"0";
        }
        return A+" "+B+" "+C;
    }
}
