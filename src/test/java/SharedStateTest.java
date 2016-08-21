import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SharedStateTest {

    @Spy
    private SharedState sharedState = new SharedState();

    @Test
    public void load() throws Exception {
        when(sharedState.remoteCheck())
//                .thenReturn(false)
                .thenReturn(true);

        sharedState.load(1000000);

//        verify(sharedState, times(1)).doLoad();
//        verify(sharedState, times(2)).remoteCheck();

    }

}