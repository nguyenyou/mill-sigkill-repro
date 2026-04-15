package generated

final case class Data1115(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1115 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1115 = copy(value = value * k)
  def addTag(t: String): Data1115 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1115 = copy(meta = meta.updated(k, v))
  def merge(other: Data1115): Data1115 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1115 {
  given Ordering[Data1115] = Ordering.by(_.id)
  def empty: Data1115 = Data1115(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1115 =
    Data1115(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1115] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
