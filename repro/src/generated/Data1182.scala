package generated

final case class Data1182(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1182 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1182 = copy(value = value * k)
  def addTag(t: String): Data1182 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1182 = copy(meta = meta.updated(k, v))
  def merge(other: Data1182): Data1182 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1182 {
  given Ordering[Data1182] = Ordering.by(_.id)
  def empty: Data1182 = Data1182(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1182 =
    Data1182(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1182] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
