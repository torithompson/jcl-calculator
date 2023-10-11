package jcl.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
     @RequestMapping("/")
     public String index() {
         return "index";
     }
    
    @PostMapping("/calculate")
    public String calculateBlockSize(@RequestParam("fileSize") int fileSize,
            @RequestParam("blockingFactor") int blockingFactor, Model model) {
        // Perform your space calculation logic here
        int blockSize = fileSize * blockingFactor;

        // Pass the result to the front end for display
        model.addAttribute("fileSize", fileSize);
        model.addAttribute("blockSize", blockSize);
        model.addAttribute("blockingFactor", blockingFactor);
        // Return a view to display the result (you can create a result.html)
        return "result";
    }
    
    @PostMapping("block-calculate")
    public String calculateBlockSpace(@RequestParam("fileSize") int fileSize,
            @RequestParam("blockSize") int blockSize, @RequestParam("blockingFactor") int blockingFactor,
            @RequestParam("recordNum") int recordNum, @RequestParam(value= "maxRecords", required = false) String maxRecords, Model model) {
        // Perform your space calculation logic here
        if (maxRecords.isEmpty()) {
            int blockSpace = recordNum / blockingFactor;
            int maxSpace = 0;
            // Pass the result to the front end for display
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("blockSpace", blockSpace);
            model.addAttribute("maxSpace", maxSpace);
        } else {
            int minSpace = recordNum / blockingFactor;
            int maxSpace = (Integer.parseInt(maxRecords) - recordNum) / 15 / blockingFactor;
            // Pass the result to the front end for display
            model.addAttribute("maxSpace", maxSpace);
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("minSpace", minSpace);
            model.addAttribute("maxSpace", maxSpace);
        }
        return "blockSpaceResult";

    }

    @PostMapping("cyl-calculate")
    public String calculateCylSpace(@RequestParam("fileSize") int fileSize, @RequestParam("blockSize") int blockSize,
        @RequestParam("blockingFactor") int blockingFactor, @RequestParam("cylNum") int cylNum,
            @RequestParam(value = "maxCylinders", required = false) String maxCylinders, Model model) {
        // Perform your space calculation logic here
        if (maxCylinders.isEmpty()) {
            int maxCyl = 0;
            model.addAttribute("maxCyl", maxCyl);
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("cylNum", cylNum);
        } else {
            int maxCyl = (Integer.parseInt(maxCylinders) - cylNum) / 15;
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("cylNum", cylNum);
            model.addAttribute("maxCyl", maxCyl);
        }
        return "cylSpaceResult";
    }
    
    @PostMapping("track-calculate")
    public String calculateTrackSpace(@RequestParam("fileSize") int fileSize, @RequestParam("blockSize") int blockSize,
        @RequestParam("blockingFactor") int blockingFactor, @RequestParam("trackNum") int trackNum,
            @RequestParam(value = "maxTrack", required = false) String maxTracks, Model model) {
        // Perform your space calculation logic here
        if (maxTracks.isEmpty()) {
            int maxTrack = 0;
            model.addAttribute("maxTrack", maxTrack);
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("trackNum", trackNum);
        } else {
            int maxTrack = (Integer.parseInt(maxTracks) - trackNum) / 15;
            model.addAttribute("fileSize", fileSize);
            model.addAttribute("blockSize", blockSize);
            model.addAttribute("blockingFactor", blockingFactor);
            model.addAttribute("trackNum", trackNum);
            model.addAttribute("maxTrack", maxTrack);
        }
        return "trackSpaceResult";
    }

}
