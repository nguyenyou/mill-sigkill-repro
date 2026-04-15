package generated

final case class Data705(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data705 = copy(name = name.toUpperCase)
  def scale(k: Double): Data705 = copy(value = value * k)
  def addTag(t: String): Data705 = copy(tags = t :: tags)
  def put(k: String, v: String): Data705 = copy(meta = meta.updated(k, v))
  def merge(other: Data705): Data705 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data705 {
  given Ordering[Data705] = Ordering.by(_.id)
  def empty: Data705 = Data705(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data705 =
    Data705(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data705] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
