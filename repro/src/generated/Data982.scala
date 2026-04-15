package generated

final case class Data982(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data982 = copy(name = name.toUpperCase)
  def scale(k: Double): Data982 = copy(value = value * k)
  def addTag(t: String): Data982 = copy(tags = t :: tags)
  def put(k: String, v: String): Data982 = copy(meta = meta.updated(k, v))
  def merge(other: Data982): Data982 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data982 {
  given Ordering[Data982] = Ordering.by(_.id)
  def empty: Data982 = Data982(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data982 =
    Data982(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data982] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
