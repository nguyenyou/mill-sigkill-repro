package generated

final case class Data1021(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1021 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1021 = copy(value = value * k)
  def addTag(t: String): Data1021 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1021 = copy(meta = meta.updated(k, v))
  def merge(other: Data1021): Data1021 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1021 {
  given Ordering[Data1021] = Ordering.by(_.id)
  def empty: Data1021 = Data1021(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1021 =
    Data1021(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1021] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
