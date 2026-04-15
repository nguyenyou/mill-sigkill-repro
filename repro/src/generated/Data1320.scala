package generated

final case class Data1320(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1320 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1320 = copy(value = value * k)
  def addTag(t: String): Data1320 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1320 = copy(meta = meta.updated(k, v))
  def merge(other: Data1320): Data1320 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1320 {
  given Ordering[Data1320] = Ordering.by(_.id)
  def empty: Data1320 = Data1320(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1320 =
    Data1320(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1320] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
