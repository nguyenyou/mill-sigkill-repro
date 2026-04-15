package generated

final case class Data1237(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1237 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1237 = copy(value = value * k)
  def addTag(t: String): Data1237 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1237 = copy(meta = meta.updated(k, v))
  def merge(other: Data1237): Data1237 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1237 {
  given Ordering[Data1237] = Ordering.by(_.id)
  def empty: Data1237 = Data1237(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1237 =
    Data1237(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1237] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
