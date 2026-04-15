package generated

final case class Data1259(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1259 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1259 = copy(value = value * k)
  def addTag(t: String): Data1259 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1259 = copy(meta = meta.updated(k, v))
  def merge(other: Data1259): Data1259 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1259 {
  given Ordering[Data1259] = Ordering.by(_.id)
  def empty: Data1259 = Data1259(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1259 =
    Data1259(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1259] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
