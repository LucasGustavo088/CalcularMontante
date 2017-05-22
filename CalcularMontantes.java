import javax.swing.JOptionPane;

public class CalcularMontantes {
   public static void main(String [] args){
      //variaveis
      double valorAnual[], taxa;
      double valor;
      int anos;
      
      //entrada com validação de dados
      do {
         valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor inicial"));
         taxa = Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem da taxa anual (%)"));
         anos = Integer.parseInt(JOptionPane.showInputDialog("Quantos anos ficará aplicado?"));
         
         if(!(valor >= 0 && taxa >= 0 && anos >= 0))
            JOptionPane.showMessageDialog(null, "Dados inválidos! Digite novamente");  
      
      } while( !(valor >= 0 && taxa >= 0 && anos >= 0));
     
      
      //instanciando o vetor e calculando os valores
      valorAnual = new double[anos + 1];
         //valor inicial para o array
         valorAnual[0] = valor;  
         
      
      //saída de dados
      String msg = String.format("Valor inicial: %.2f | Taxa ao ano: %.1f%% | Anos de aplicação: %d", 
                                 valor, taxa, anos);      
      System.out.println(msg);
      //convertendo a taxa de porcentagem para fração
         taxa = (taxa / 100) + 1; //1 para aumento (pegar 100% do valor e adicionar a taxa dada)
      //PG
      for(int i = 1; i <= anos; i++){
         valorAnual[i] = valorAnual[i - 1] * taxa;
         System.out.format("Valor no %dº ano: %.2f\n", i, valorAnual[i]);
      }
      
      System.exit(0);
   }
}