package generated

final case class Data686(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data686 = copy(name = name.toUpperCase)
  def scale(k: Double): Data686 = copy(value = value * k)
  def addTag(t: String): Data686 = copy(tags = t :: tags)
  def put(k: String, v: String): Data686 = copy(meta = meta.updated(k, v))
  def merge(other: Data686): Data686 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data686 {
  given Ordering[Data686] = Ordering.by(_.id)
  def empty: Data686 = Data686(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data686 =
    Data686(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data686] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
