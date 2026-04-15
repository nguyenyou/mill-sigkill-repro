package generated

final case class Data687(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data687 = copy(name = name.toUpperCase)
  def scale(k: Double): Data687 = copy(value = value * k)
  def addTag(t: String): Data687 = copy(tags = t :: tags)
  def put(k: String, v: String): Data687 = copy(meta = meta.updated(k, v))
  def merge(other: Data687): Data687 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data687 {
  given Ordering[Data687] = Ordering.by(_.id)
  def empty: Data687 = Data687(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data687 =
    Data687(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data687] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
