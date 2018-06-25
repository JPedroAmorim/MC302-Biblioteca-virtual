package trabalho1;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public interface SalvarLer {

    public void salvar(Writer writer) throws IOException;

    public String ler(File arquivo) throws IOException;

}
