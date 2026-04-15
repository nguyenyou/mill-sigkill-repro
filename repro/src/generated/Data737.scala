package generated

final case class Data737(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data737 = copy(name = name.toUpperCase)
  def scale(k: Double): Data737 = copy(value = value * k)
  def addTag(t: String): Data737 = copy(tags = t :: tags)
  def put(k: String, v: String): Data737 = copy(meta = meta.updated(k, v))
  def merge(other: Data737): Data737 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data737 {
  given Ordering[Data737] = Ordering.by(_.id)
  def empty: Data737 = Data737(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data737 =
    Data737(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data737] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
