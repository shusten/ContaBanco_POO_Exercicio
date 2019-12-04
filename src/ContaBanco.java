public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        System.out.println("-----------------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
        System.out.println("-----------------------------------------------");
    }

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
                if("CC".equals(t)) {
             setSaldo(50);
                } else if ("CP".equals(t)) {
            setSaldo(150);
                }
        System.out.println("=======================================");
        System.out.println("Conta aberta com sucesso!");
        System.out.println("=======================================");
    }

    public void fecharConta() {
        if ( this.getSaldo() > 0 ) {
            System.out.println("Não pode fechar uma conta com dinheiro");
        } else if ( this.getSaldo() < 0 ){
            System.out.println("Não pode se fechar uma conta em débito");
        } else {
            setStatus(false);
            System.out.println("=======================================");
            System.out.println("Conta fechada com sucesso!");
            System.out.println("=======================================");
        }
    }

    public void depositar(float v){
        if ( this.getStatus() ) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("=======================================");
            System.out.println("Depósito realizado na conta de:" + this.getDono());
            System.out.println("=======================================");
        } else {
            System.out.println("=======================================");
            System.out.println("Impossível depositar em uma conta fechada!");
            System.out.println("=======================================");
        }

    }
    public void sacar(float v) {
        if ( this.getStatus() ) {
            if ( this.getSaldo() >= v ) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("=======================================");
                System.out.println("Saque realizado na conta de: " + this.getDono());
                System.out.println("=======================================");
            } else {
                System.out.println("SALDO INSUFICIENTE!");
            }
        } else {
            System.out.println("IMPOSSÍVEL SACAR DE UMA CONTA FECHADA!");
        }
    }
    public void pagarMensal() {
        float v = 0;
        if ( getTipo().equals("CC") ) {
            v = 12;
        } else if (getTipo().equals("CP")) {
            v = 20;
        }
        if ( getStatus() ) {
            if ((getSaldo() > v)) {
                setSaldo(getSaldo() - v);
                System.out.println("=============================================");
                System.out.println(this.getDono() + ", mensalidade paga com sucesso!" );
                System.out.println("=============================================");
            } else {
                System.out.println("SALDO INSUFICIENTE");
            }
        } else {
            System.out.println("IMPOSSÍVEL PAGAR!");
        }
    }

    //                    ======= Método Construtor ========

    public ContaBanco(){
        this.setSaldo(0);
        this.setStatus(false);
    }


    //                        ====Métodos Especiais ========

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
