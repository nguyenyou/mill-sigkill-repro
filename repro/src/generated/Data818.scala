package generated

final case class Data818(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data818 = copy(name = name.toUpperCase)
  def scale(k: Double): Data818 = copy(value = value * k)
  def addTag(t: String): Data818 = copy(tags = t :: tags)
  def put(k: String, v: String): Data818 = copy(meta = meta.updated(k, v))
  def merge(other: Data818): Data818 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data818 {
  given Ordering[Data818] = Ordering.by(_.id)
  def empty: Data818 = Data818(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data818 =
    Data818(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data818] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
