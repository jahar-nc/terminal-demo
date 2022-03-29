# What is the terminal

A beginners guide to the terminal.

Like `cmd.exe`, the terminal is where you can type commands into
a prompt and then have them executed. A terminal is more fully featured than
`cmd.exe`. Easily allowing you to link commands together and offering tab completion.

The shell is what the terminal uses to read commands and go and execute them. It is
turing complete. Indeed many scripts are written that solely use the shell.
There are many different shells, but typically the default is `bash` (Bourne again shell).
This doesn't mean it's the best shell out there, just the most common.

# Filesystem Hierarchy (Standard)

Predefines where given types of files should exist.

The root is `/`. This is broadly comparable to `C:\\`.
`/bin` is where most executables and programs live.
`/home` contains each user's personal directory. Except
for the admin user (`root`), which uses `/root`.

## The root user and permissions

The root user is completely unrestricted and can do anything.
Executing `rm -rf /` as root will destroy your system and
make it unusable.


# Navigation

Commands for moving around the filesystem and seeing what exists.

* pwd
* ls
* cd

# File Manipulation

Commands for navigating your machine and modifying the filesystems

* touch
* mv
* cp
* rm
* mkdir
* rmdir

# Examining and editing files

* less (how to search with `/`)
* nano/vim/emacs (recommend getting familar with `vim`)
* grep
* cat
* tail

# Checking and manipulating processes

* ps
* top (`q` to quit).
* Ctrl-C vs Ctrl-D vs Ctrl-Z (plus fg and bg)
* kill

# Variables

* check the value of a variable
* uppercase used to denote environment variables
* how to set and unset variables
* how to make variables available to subprocesses (export)
* Special variables eg. `$?` -- did the last program exit happily or not
* list all environment variables `env`

Check the value of a variable:

```shell
echo $USER
# or
echo ${USER} # braces delinate what is the name of the variable
# eg. compare:
echo ${USER}1
# vs
echo $USER1
```

Setting variables:

```shell
foo=bar  # no spaces around the `=` sign
echo $foo
```

Quoting can ensure spaces in variables are preserved. eg

```shell
foo="bar baz"  # NB. " is not part of the variable contents
cat > script.py << EOF
import sys
print('got', len(sys.argv), 'args')
print('args are:', sys.argv)
EOF
python3 script.py $foo # two separate args!
python3 script.py "$foo" # preserve spaces in single arg
```

Use `export` to make your variables available to child processes

compare eg.
```shell
# NB. brackets "()" creates a child shell to execute commands in
foo=bar
( env | grep foo )
# vs
export foo=bar
( env | grep foo )
```

# Installing new software

* apt vs yum (debian vs red hat)

# Pipes and redirection

How to use `|` and `>`

How to use `&&` to chain together commands that stop on the first failure

# Getting help

`man` can be used to get help on a given command. It uses `less` to provide this information
in the terminal. For example `man ls`. To navigate use PgUp, PgDown and the arrow keys. To exit press `q`.
If that doesn't work, press Esc a few times and then press `q`.

# Useful Links

* https://digitalocean.com/community/tutorials/an-introduction-to-linux-basics

