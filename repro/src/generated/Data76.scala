package generated

final case class Data76(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data76 = copy(name = name.toUpperCase)
  def scale(k: Double): Data76 = copy(value = value * k)
  def addTag(t: String): Data76 = copy(tags = t :: tags)
  def put(k: String, v: String): Data76 = copy(meta = meta.updated(k, v))
  def merge(other: Data76): Data76 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data76 {
  given Ordering[Data76] = Ordering.by(_.id)
  def empty: Data76 = Data76(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data76 =
    Data76(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data76] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
