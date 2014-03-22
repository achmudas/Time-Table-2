package org.kutkaitis.timetable2.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author achmudas
 */
@ManagedBean
@SessionScoped
public class FileUploadController {
    private static FacesMessage msg;
    
    public static void handleFileUpload(FileUploadEvent event) {
         try {
            File targetFolder = new File("/Users/achmudas/Desktop/testing");
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(new File(targetFolder,
                    event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                System.out.println("read, " +read + "bytes, " + bytes.toString());
            }
            msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
            inputStream.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            msg = new FacesMessage("Failed", event.getFile().getFileName() + " is not uploaded.");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
         }
       
    }
    
}
