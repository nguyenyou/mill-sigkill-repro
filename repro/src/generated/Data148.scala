package generated

final case class Data148(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data148 = copy(name = name.toUpperCase)
  def scale(k: Double): Data148 = copy(value = value * k)
  def addTag(t: String): Data148 = copy(tags = t :: tags)
  def put(k: String, v: String): Data148 = copy(meta = meta.updated(k, v))
  def merge(other: Data148): Data148 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data148 {
  given Ordering[Data148] = Ordering.by(_.id)
  def empty: Data148 = Data148(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data148 =
    Data148(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data148] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
