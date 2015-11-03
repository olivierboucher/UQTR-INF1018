package com.olivierboucher.inf1018;

import com.olivierboucher.inf1018.lexical.Lexer;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olivier on 2015-11-02.
 */
public class Main {

    public static void main(String [] args) {
        //TODO(Olivier): Assert that args[0] is provided
        if(args.length != 1) { //NOTE(Olivier): This is strict, maybe we could use < 0
            System.out.println("Wrong number of arguments provided. Please specify only one file");
            System.exit(1);
        }

        File file = new File(args[0]);

        //TODO(Olivier): Assert that the path exists
        if(!file.exists()){
            System.out.println("The provided path does not exist.");
            System.exit(1);
        }

        //TODO(Olivier): Assert that the path leads to a file
        if(!file.isFile()){ //NOTE(Olivier): We could allow directory and analyze every file contained
            System.out.println("The provided path must lead to a file");
            System.exit(1);
        }

        //TODO(Olivier): Assert that we can read the file
        if(!file.canRead()){
            System.out.println("File permissions does not allow reading.");
            System.exit(1);
        }

        Lexer lexer = new Lexer(file);

        //NOTE(Olivier): This is for debugging purposes
        List<Lexer.Token> tokens = lexer.getAllTokens()
                .stream()
                .filter((Lexer.Token t) -> t.type != Lexer.TokenType.WHITESPACE)
                .collect(Collectors.toList());

        System.out.println(String.format("Got %d tokens", tokens.size()));

        tokens.forEach(System.out::println);
    }
}
