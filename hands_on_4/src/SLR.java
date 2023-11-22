
public class SLR {
    private int n;
    private int sumatoriaXY;
    private int sumatoriaX;
    private int sumatoriaY;
    private int sumatoriaXAlCuadrado;
    private float sumatoriaYMenosYHatAlCuadrado;
    private float sumatoriaYMenosPromedioY;
    DataSet dataSet = new DataSet();
    private int[] x = dataSet.getX();
    private int[] y = dataSet.getY();
    
    public SLR(){
    }
    
    public float b1() {
        this.n = this.x.length;

        this.sumatoriaXY = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaXY += (this.x[i] * this.y[i]);
        }

        this.sumatoriaX = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaX += this.x[i];
        }

        this.sumatoriaY = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaY += this.y[i];
        }

        this.sumatoriaXAlCuadrado = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaXAlCuadrado += Math.pow(this.x[i],2);
        }

        float beta1 = (float) ((this.n * this.sumatoriaXY - this.sumatoriaX * this.sumatoriaY) / 
                (this.n * this.sumatoriaXAlCuadrado - Math.pow(this.sumatoriaX,2)));

        return beta1;
    }
    
    public float b0() {
        this.n = this.x.length;

        this.sumatoriaY = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaY += y[i];
        }

        this.sumatoriaX = 0;
        for (int i = 0; i < this.n; i++) {
            this.sumatoriaX += this.x[i];
        }

        float beta0 = (this.sumatoriaY - b1() * this.sumatoriaX) / this.n;

        return beta0;
    }
    
    public float rCuadrada(){
        this.sumatoriaYMenosYHatAlCuadrado = 0;
        for(int i = 0; i < this.n; i++){
            this.sumatoriaYMenosYHatAlCuadrado += Math.pow((y[i] - (b0() + b1() * x[i])), 2);
        }
        
        float promedioY = 0;
        for(int i=0; i < this.n; i++){
            promedioY += y[i];
        }
        promedioY = promedioY / this.n;
        
        this.sumatoriaYMenosPromedioY = 0;
        for(int i = 0; i < this.n; i++){
            this.sumatoriaYMenosPromedioY += Math.pow((y[i] - promedioY), 2);
        }
        
        float R = 1 - (this.sumatoriaYMenosYHatAlCuadrado / this.sumatoriaYMenosPromedioY);
        
        return R;
    }

}
