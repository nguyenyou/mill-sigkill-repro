package generated

final case class Data596(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data596 = copy(name = name.toUpperCase)
  def scale(k: Double): Data596 = copy(value = value * k)
  def addTag(t: String): Data596 = copy(tags = t :: tags)
  def put(k: String, v: String): Data596 = copy(meta = meta.updated(k, v))
  def merge(other: Data596): Data596 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data596 {
  given Ordering[Data596] = Ordering.by(_.id)
  def empty: Data596 = Data596(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data596 =
    Data596(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data596] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
