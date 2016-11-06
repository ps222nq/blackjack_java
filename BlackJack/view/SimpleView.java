package BlackJack.view;

public class SimpleView implements IView 
{

  public void DisplayWelcomeMessage()
        {
          for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public BlackJack.view.IView.MenuChoice GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return MenuChoiceForInput((char)c);
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return BlackJack.view.IView.MenuChoice.Quit;
          }
        }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }

        private BlackJack.view.IView.MenuChoice MenuChoiceForInput(char input)
        {
            BlackJack.view.IView.MenuChoice c;
            switch (input){
                case 'p':
                    c = BlackJack.view.IView.MenuChoice.NewGame;
                    break;
                case 'h':
                    c = BlackJack.view.IView.MenuChoice.Hit;
                    break;
                case 's':
                    c = BlackJack.view.IView.MenuChoice.Stand;
                    break;
                case 'q':
                    c = BlackJack.view.IView.MenuChoice.Quit;
                    break;
                default:
                    c = BlackJack.view.IView.MenuChoice.Quit;
                    break;

            }
            return c;
        }
    }
