package generated

final case class Data235(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data235 = copy(name = name.toUpperCase)
  def scale(k: Double): Data235 = copy(value = value * k)
  def addTag(t: String): Data235 = copy(tags = t :: tags)
  def put(k: String, v: String): Data235 = copy(meta = meta.updated(k, v))
  def merge(other: Data235): Data235 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data235 {
  given Ordering[Data235] = Ordering.by(_.id)
  def empty: Data235 = Data235(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data235 =
    Data235(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data235] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
