package net.grydeske.security

class PirateNameGeneratorService {

    def pirateTokens = ['arr', 'peg', 'timber', 'monkey', 'knife', 'powder', 'grog', 'scuttle', 'keel',
                        'cannon', 'jib', 'cutlass', 'mast', 'plank', 'matey', 'bag', 'doubloon', 'rope', 'rum', 'chip',
                        'lubber', 'spit', 'patch', 'salt', 'tack', 'tortuga']
    Random rand = new Random()


    String getRandomPirateToken() {
        pirateTokens[rand.nextInt(pirateTokens.size())]
    }

    String generatePirateName(String name) {
        if( !name) {
            return ''
        }
        "${name.length() > 5 ? name[0..5] : name} ${randomPirateToken} ${randomPirateToken}"
    }
}
