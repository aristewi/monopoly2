package monopoly2.monopoly2;

import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameBoardCCJail;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.IOwnable;
import edu.ncsu.monopoly.JailCard;
import edu.ncsu.monopoly.MockGUI;
import junit.framework.TestCase;

public class GoToJailCardTest extends TestCase {
    GameMaster gameMaster;
    Card jailCard = new JailCard(Card.TYPE_CC);
    
    protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCJail());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gameMaster.getGameBoard().addCard(jailCard);
    }
    
    public void testJailCardAction() {
		Card card = gameMaster.drawCCCard();
		assertEquals(jailCard, card);
		card.applyAction();
		IOwnable cell = gameMaster.getCurrentPlayer().getPosition();
		assertEquals(gameMaster.getGameBoard().queryCell("Jail"), cell);
    }
    
    public void testJailCardLabel() {
        assertEquals("Go to Jail immediately without collecting" +
        		" $200 when passing the GO cell", jailCard.getLabel());
    }
    
    public void testJailCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		IOwnable cell = gameMaster.getCurrentPlayer().getPosition();
		assertEquals(gameMaster.getGameBoard().queryCell("Jail"), cell);
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}