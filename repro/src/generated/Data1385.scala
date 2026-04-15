package generated

final case class Data1385(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1385 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1385 = copy(value = value * k)
  def addTag(t: String): Data1385 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1385 = copy(meta = meta.updated(k, v))
  def merge(other: Data1385): Data1385 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1385 {
  given Ordering[Data1385] = Ordering.by(_.id)
  def empty: Data1385 = Data1385(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1385 =
    Data1385(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1385] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
