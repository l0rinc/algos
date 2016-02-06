package pap.lorinc.algos.sandbox

import spock.lang.Specification

import javax.imageio.ImageIO

import static ImageHorizontalFlip.flipX
import static java.awt.Color.WHITE

class ImageHorizontalFlipTest extends Specification {
    /*@formatter:off*/
    def 'flipX?'() {
        when:  def (originalImage, w) = readImage('YinYang.bmp')
               def (targetImage, _)   = readImage('YinYang_FlipX.bmp')
        then:  flipX(originalImage, w) == targetImage
    }
    /*@formatter:on*/

    static readImage(String resource) {
        def image = ImageIO.read(getResourceAsStream(resource))
        def (height, width) = [image.tileHeight, image.tileWidth]
        BitSet[] result = (0..<height).collect { int y ->
            (0..<width).inject(new BitSet(width)) { BitSet row, int x ->
                row.set(x, image.getRGB(x, y) == WHITE.RGB); row
            }
        }
        [result, width]
    }
}
