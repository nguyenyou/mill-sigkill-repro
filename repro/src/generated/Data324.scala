package generated

final case class Data324(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data324 = copy(name = name.toUpperCase)
  def scale(k: Double): Data324 = copy(value = value * k)
  def addTag(t: String): Data324 = copy(tags = t :: tags)
  def put(k: String, v: String): Data324 = copy(meta = meta.updated(k, v))
  def merge(other: Data324): Data324 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data324 {
  given Ordering[Data324] = Ordering.by(_.id)
  def empty: Data324 = Data324(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data324 =
    Data324(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data324] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
