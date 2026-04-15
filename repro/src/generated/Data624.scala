package generated

final case class Data624(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data624 = copy(name = name.toUpperCase)
  def scale(k: Double): Data624 = copy(value = value * k)
  def addTag(t: String): Data624 = copy(tags = t :: tags)
  def put(k: String, v: String): Data624 = copy(meta = meta.updated(k, v))
  def merge(other: Data624): Data624 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data624 {
  given Ordering[Data624] = Ordering.by(_.id)
  def empty: Data624 = Data624(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data624 =
    Data624(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data624] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
