package com.alimmit;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.util.StringUtils;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FdicBranchFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        FdicBranchFunctionClient client = server.getApplicationContext().getBean(FdicBranchFunctionClient.class);

        assertTrue(StringUtils.isNotEmpty(client.apply(new BranchSearch("Wells River Savings Bank", StringUtils.EMPTY_STRING, new String[] {"NAME", "OFFNAME"})).blockingGet()));
        server.stop();
    }
}
