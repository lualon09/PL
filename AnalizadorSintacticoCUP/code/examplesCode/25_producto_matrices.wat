(module
(type $_sig_i32i32i32 (func (param i32 i32 i32) ))
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $show (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $preMain)
(func $preMain 
 (local $temp i32)
 (local $localsStart i32)
 i32.const 4
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 call $main
 drop
 call $freeStack
)
 ;; generating code of function imprimirMatriz
(func $imprimirMatriz

 (local $temp i32)
 (local $localsStart i32)
 i32.const 52
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:3))
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 3
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:j(type:INT)=(INT:0)
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(j),(INT:3))
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 3
 i32.lt_s
 i32.eqz
 br_if 1
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(matriz)[AVar(i)])
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 12
 i32.mul
 ;;generating code for access arrayAVar(matriz)
 ;; loading parammatriz
 i32.const 0
 local.get $localsStart
 i32.add
 ;; parameter is by reference
 i32.load
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(j),(INT:1))
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;; generating code for IReturn
 call $freeStack
 return
)
 ;; generating code of function productoMatrices
(func $productoMatrices
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 140
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:filasMatriz1(type:INT)=(INT:3)
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:columnasMatriz1(type:INT)=(INT:3)
 i32.const 12
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:columnasMatriz2(type:INT)=(INT:3)
 i32.const 16
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:resultado(type:List<List<INT>[(INT:3)]>[(INT:3)])=[[(INT:0), (INT:0), (INT:0)], [(INT:0), (INT:0), (INT:0)], [(INT:0), (INT:0), (INT:0)]]
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 16
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 20
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 24
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 28
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 32
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 56
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),AVar(filasMatriz1))
 ;;generating code for access
 i32.const 56
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:j(type:INT)=(INT:0)
 i32.const 60
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(j),AVar(columnasMatriz2))
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 16
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:k(type:INT)=(INT:0)
 i32.const 64
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(k),AVar(columnasMatriz1))
 ;;generating code for access
 i32.const 64
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 12
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for assignation assign:AArray (AArray (AVar(resultado)[AVar(i)])[AVar(j)])=SUM(AArray (AArray (AVar(resultado)[AVar(i)])[AVar(j)]),MUL(AArray (AArray (AVar(matriz1)[AVar(i)])[AVar(k)]),AArray (AArray (AVar(matriz2)[AVar(k)])[AVar(j)])))
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(resultado)[AVar(i)])
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 56
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 12
 i32.mul
 ;;generating code for access arrayAVar(resultado)
 i32.const 20
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 ;;generating code for exp ebinSUM(AArray (AArray (AVar(resultado)[AVar(i)])[AVar(j)]),MUL(AArray (AArray (AVar(matriz1)[AVar(i)])[AVar(k)]),AArray (AArray (AVar(matriz2)[AVar(k)])[AVar(j)])))
 ;;generating code for access
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(resultado)[AVar(i)])
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 56
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 12
 i32.mul
 ;;generating code for access arrayAVar(resultado)
 i32.const 20
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 ;;generating code for exp ebinMUL(AArray (AArray (AVar(matriz1)[AVar(i)])[AVar(k)]),AArray (AArray (AVar(matriz2)[AVar(k)])[AVar(j)]))
 ;;generating code for access
 ;;generating code for index of arrayAVar(k)
 ;;generating code for access
 i32.const 64
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(matriz1)[AVar(i)])
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 56
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 12
 i32.mul
 ;;generating code for access arrayAVar(matriz1)
 ;; loading parammatriz1
 i32.const 0
 local.get $localsStart
 i32.add
 ;; parameter is by reference
 i32.load
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 ;;generating code for access
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(matriz2)[AVar(k)])
 ;;generating code for index of arrayAVar(k)
 ;;generating code for access
 i32.const 64
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 12
 i32.mul
 ;;generating code for access arrayAVar(matriz2)
 ;; loading parammatriz2
 i32.const 4
 local.get $localsStart
 i32.add
 ;; parameter is by reference
 i32.load
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 i32.mul
 i32.add
 i32.store
 ;;end generating code for assignation assign:AArray (AArray (AVar(resultado)[AVar(i)])[AVar(j)])=SUM(AArray (AArray (AVar(resultado)[AVar(i)])[AVar(j)]),MUL(AArray (AArray (AVar(matriz1)[AVar(i)])[AVar(k)]),AArray (AArray (AVar(matriz2)[AVar(k)])[AVar(j)])))
 ;;generating code for assignation assign:AVar(k)=SUM(AVar(k),(INT:1))
 i32.const 64
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(k),(INT:1))
 ;;generating code for access
 i32.const 64
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(k)=SUM(AVar(k),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 i32.const 60
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(j),(INT:1))
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 56
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 56
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;; generating code for IReturn
 i32.const 20
 local.get $localsStart
 i32.add
 call $freeStack
 return
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 116
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:matriz1(type:List<List<INT>[(INT:3)]>[(INT:3)])=[[(INT:1), (INT:2), (INT:1)], [(INT:0), (INT:1), (INT:0)], [(INT:1), (INT:0), (INT:1)]]
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 16
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 20
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 24
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 28
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 32
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:matriz2(type:List<List<INT>[(INT:3)]>[(INT:3)])=[[(INT:2), (INT:4), (INT:0)], [(INT:1), (INT:3), (INT:0)], [(INT:0), (INT:1), (INT:1)]]
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 4
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 16
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 20
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 24
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 28
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 32
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:resultado(type:List<List<INT>[(INT:3)]>[(INT:3)])=call:productoMatrices([AVar(matriz1), AVar(matriz2)])
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(matriz1)
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 0
 local.get $temp
 i32.add
 i32.const 9
 call $copyn
 i32.const 0
 local.get $temp
 i32.add
 i32.const 0
 local.get $localsStart
 i32.add
 i32.store
;; Treating the argument AVar(matriz2)
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 4
 local.get $temp
 i32.add
 i32.const 9
 call $copyn
 i32.const 4
 local.get $temp
 i32.add
 i32.const 36
 local.get $localsStart
 i32.add
 i32.store
 ;; end copying arguments
 call $productoMatrices
 i32.const 72
 local.get $localsStart
 i32.add
 i32.const 9
 call $copyn
 ;;end generating code for declaration
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(resultado)
 i32.const 72
 local.get $localsStart
 i32.add
 i32.const 0
 local.get $temp
 i32.add
 i32.const 9
 call $copyn
 i32.const 0
 local.get $temp
 i32.add
 i32.const 72
 local.get $localsStart
 i32.add
 i32.store
 ;; end copying arguments
 call $imprimirMatriz
 ;; generating code for IReturn
 ;;generating code for EConst
 i32.const 0
 call $freeStack
 return
)
(func $reserveStack (param $size i32)
   (result i32)
   global.get $MP
   global.get $SP
   global.set $MP
   global.get $SP
   local.get $size
   i32.add
   global.set $SP
   global.get $SP
   global.get $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)

(func $freeStack (type $_sig_void)
   global.get $MP
   global.set $SP
   global.get $MP
   i32.load
   global.set $MP   
)

(func $reserveHeap (type $_sig_i32)
   (param $size i32)


   global.get $NP
   local.get $size
   i32.sub
   global.set $NP
  


)

(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       local.get $n
       i32.eqz
       br_if 1
       local.get $n
       i32.const 1
       i32.sub
       local.set $n
       local.get $dest
       local.get $src
       i32.load
       i32.store
       local.get $dest
       i32.const 4
       i32.add
       local.set $dest
       local.get $src
       i32.const 4
       i32.add
       local.set $src
       br 0
     end
   end
)
(export "memory" (memory 0))
(export "init" (func $preMain))
)


