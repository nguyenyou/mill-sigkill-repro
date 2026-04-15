package generated

final case class Data218(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data218 = copy(name = name.toUpperCase)
  def scale(k: Double): Data218 = copy(value = value * k)
  def addTag(t: String): Data218 = copy(tags = t :: tags)
  def put(k: String, v: String): Data218 = copy(meta = meta.updated(k, v))
  def merge(other: Data218): Data218 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data218 {
  given Ordering[Data218] = Ordering.by(_.id)
  def empty: Data218 = Data218(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data218 =
    Data218(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data218] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
