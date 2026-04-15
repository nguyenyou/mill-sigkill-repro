package generated

final case class Data996(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data996 = copy(name = name.toUpperCase)
  def scale(k: Double): Data996 = copy(value = value * k)
  def addTag(t: String): Data996 = copy(tags = t :: tags)
  def put(k: String, v: String): Data996 = copy(meta = meta.updated(k, v))
  def merge(other: Data996): Data996 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data996 {
  given Ordering[Data996] = Ordering.by(_.id)
  def empty: Data996 = Data996(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data996 =
    Data996(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data996] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
