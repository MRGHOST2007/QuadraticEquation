package ir.mrghost.moadeleD2;

public class QuadraticEquation {

    public float calculateDelta(float a, float b, float c) { return (b * b) - (4 * a * c); }

    public float calculateRoot0(float a, float b) {
        float root;
        root = (-b) / (2 * a);
        return root;
    }

    public float calculateRoot1(float a , float b , float delta){
        float root1F;
        root1F = (float) (((-b) + Math.sqrt(delta)) / (2 * a));
        return root1F;
    }
    public float calculateRoot2(float a , float b , float delta){
        float root2F;
        root2F = (float) (((-b) - Math.sqrt(delta)) / (2 * a));
        return root2F;
    }
}
